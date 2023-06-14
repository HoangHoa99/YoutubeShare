import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NotifierService } from 'angular-notifier';
import { Globals } from '../common/globals';

@Component({
  selector: 'app-share-video',
  templateUrl: './share-video.component.html',
  styleUrls: ['./share-video.component.css']
})
export class ShareVideoComponent {
  
  private readonly notifier: NotifierService;
  constructor(private router: Router, private notification: NotifierService) {
    this.notifier = notification;
  }

  
  shareVideo(event: any) {
    event.preventDefault();

    this.router.navigate([`share`]);
  }

  logoutAction(event: any) {
    event.preventDefault();

    Globals.loginResponse.clear();
    Globals.isUserLogin = !Globals.isUserLogin;

    this.router.navigate([`home`]);
  }

  getLoginEmail() {
    return Globals.loginResponse.getEmail;
  }
}
