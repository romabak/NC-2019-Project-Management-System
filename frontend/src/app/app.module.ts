import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { AuthorizationComponent } from './authorization/authorization.component';
import { AppRoutingModule } from './app-routing.module';
import { ProjectPageComponent } from './project-page/project-page.component';
import {HeaderComponent} from "./main-page/header/header.component";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";

@NgModule({
  declarations: [
    AppComponent,
    AuthorizationComponent,
    ProjectPageComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    Ng4LoadingSpinnerModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
