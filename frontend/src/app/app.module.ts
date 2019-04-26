import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { AuthorizationComponent } from './authorization/authorization.component';
import { AppRoutingModule } from './app-routing.module';
import { ProjectPageComponent } from './project-page/project-page.component';
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {LayoutModule} from "./modules/layout/layout.module";
import {PopupModule} from "./modules/main-page/popup/popup.module";
import {MainPageModule} from "./modules/main-page/main-page.module";
import { TaskPageComponent } from './modules/task-page/task-page.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthorizationComponent,
    ProjectPageComponent,
    TaskPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    Ng4LoadingSpinnerModule,
    LayoutModule,
    MainPageModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
