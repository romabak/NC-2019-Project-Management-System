import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'

import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { AuthorizationComponent } from './authorization/authorization.component';
import { AppRoutingModule } from './app-routing.module';
import { ProjectPageComponent } from './project-page/project-page.component';
import {HeaderComponent} from "./main-page/header/header.component";

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
    AppRoutingModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
