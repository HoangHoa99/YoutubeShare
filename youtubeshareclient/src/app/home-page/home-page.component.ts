import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NotifierService } from 'angular-notifier';
import { Globals, LoginResponse } from '../common/globals';
import { HomePageService } from './home-page.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  sharedVideoList: Array<Map<string, string>> = [];
  email: string = '';
  password: string = '';
  private readonly notifier: NotifierService;

  /** WS */
  webSocketEndPoint: string = 'http://localhost:8080/ws';
  topic: string = "/topic/greetings";
  stompClient: any;

  constructor(private router: Router, private service: HomePageService, private notification: NotifierService) {
    this.notifier = notification;
  }

  ngOnInit() {
    // load shared video here
    this.loadSharedVideoList();
  }

  loadSharedVideoList() {

    this.service.sharedVideoList().subscribe(data => {
      this.handleSharedVideoResponse(data);
    });
  }

  handleSharedVideoResponse(data: any) {
    if (data.error) {
      console.error("Error occur while fetching shared video ", data.message);
      return;
    }

    this.sharedVideoList = data.sharedVideoList;
  }

  onEmailChange(event: any) {
    this.email = event.target.value;
  }

  onPasswordChange(event: any) {
    this.password = event.target.value;
  }

  loginAction(event: any) {
    event.preventDefault();

    let body = {
      "email": this.email,
      "password": this.password
    }

    this.service.login(body).subscribe(data => {
      this.handleLoginResponse(data);
    });
  }

  handleLoginResponse(data: any) {
    this.email = '';
    this.password = '';
    let res = new LoginResponse(data);

    if (res.getError) {
      this.notifier.notify('failure', res.getMessage);
      return;
    }

    Globals.loginResponse = res;
    Globals.isUserLogin = true;
    this.notifier.notify('success', `User ${res.getEmail} login successful`);
  }

  getLoginEmail() {
    return Globals.loginResponse.getEmail;
  }

  userLogin() {
    return Globals.isUserLogin;
  }

  shareVideo(event: any) {
    event.preventDefault();

    this.router.navigate([`share`]);
  }

  logoutAction(event: any) {
    event.preventDefault();

    Globals.loginResponse.clear();
    Globals.isUserLogin = !Globals.isUserLogin;
  }
}
