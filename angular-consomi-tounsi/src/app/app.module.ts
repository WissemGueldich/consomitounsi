import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from "@angular/router";


import { AppComponent } from './app.component';
import { ListStocksComponent } from './components/list-stocks/list-stocks.component';
import { ListInvoicesComponent } from './components/list-invoices/list-invoices.component';
import { ListRayonsComponent } from './components/list-rayons/list-rayons.component';
import { AddInvoiceComponent } from './components/add-invoice/add-invoice.component';

import { AddStockComponent } from './components/add-stock/add-stock.component';
import { AddRayonComponent } from './components/add-rayon/add-rayon.component';
import { FormsModule ,ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardUserComponent } from './board-user/board-user.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';


const routers: Routes = [
  {path: 'invoices', component: ListInvoicesComponent},
  {path: 'addinvoice', component: AddInvoiceComponent},
  {path: 'editinvoice/:id', component: AddInvoiceComponent},

  {path: 'rayons', component: ListRayonsComponent},
  {path: 'rayon/add', component: AddRayonComponent},
  {path: 'rayon/update/:id', component: AddRayonComponent},

  {path: 'stocks', component: ListStocksComponent},
  {path: 'stock/add', component: AddStockComponent},
  {path: 'stock/update/:id', component: AddStockComponent},
  
  {path: '', redirectTo: '/invoices', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardUserComponent,
    ListInvoicesComponent,
    ListStocksComponent,
    ListRayonsComponent,
    AddInvoiceComponent,
    AddStockComponent,
    AddRayonComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routers),
    AppRoutingModule
    
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }