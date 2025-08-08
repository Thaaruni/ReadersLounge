import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [], // ❌ remove AppComponent from declarations
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AppComponent // ✅ import it here instead
  ],
  providers: [],

})
export class AppModule { }
