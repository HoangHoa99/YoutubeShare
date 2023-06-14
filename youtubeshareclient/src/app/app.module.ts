import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { NotifierModule } from 'angular-notifier';
import { HomePageService } from './home-page/home-page.service';
import { HttpClientModule } from '@angular/common/http';
import { VideoListComponent } from './video-list/video-list.component';
import { ShareVideoComponent } from './share-video/share-video.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    VideoListComponent,
    ShareVideoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NotifierModule.withConfig({
      position: {
        horizontal: {
          position: 'right',
          distance: 12
        },
        vertical: {
          position: 'top',
          distance: 12,
          gap: 10
        }
      },
      theme: 'material',
      behaviour: {
        autoHide: 5000,
        onClick: 'hide',
        onMouseover: 'pauseAutoHide',
      }
    })
  ],
  providers: [HomePageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
