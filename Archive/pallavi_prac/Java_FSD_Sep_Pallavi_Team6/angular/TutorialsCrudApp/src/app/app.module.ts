import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ListTutorialsComponent } from './list-tutorials/list-tutorials.component';
import { TutorialDetailsComponent } from './tutorial-details/tutorial-details.component';
import { AddtutorialComponent } from './addtutorial/addtutorial.component';

@NgModule({
  declarations: [
    AppComponent,
    ListTutorialsComponent,
    TutorialDetailsComponent,
    AddtutorialComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
