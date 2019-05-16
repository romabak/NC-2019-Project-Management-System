import { AppService } from '../../services/app.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainPageComponent } from './main-page/main-page.component';
import { MainPageModule } from '../main-page/main-page.module';

@NgModule({
  declarations: [MainPageComponent],
  imports: [
    CommonModule,
    MainPageModule,
  ],
  providers:[
  	AppService
  ],
  exports:[
    MainPageComponent
  ]
})
export class LayoutModule { }
