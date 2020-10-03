import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EditComponent } from './edit-company-data/edit-company-data';
import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './not-found/not-found.component';
import { CompanyBranchComponent } from './company-branch/company-branch.component';
import { CarsComponent } from './cars/cars.component';
import { KlientsComponent } from './clients/klients.component';
import { BookingComponent } from './booking/booking.component';
import { DataComponent } from './data/data.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    EditComponent,
    NotFoundComponent,
    CompanyBranchComponent,
    CarsComponent,
    KlientsComponent,
    BookingComponent,
    DataComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
