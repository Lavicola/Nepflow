import {Component, inject, OnInit} from '@angular/core';
import {CommonModule} from "@angular/common";
import {RouterModule, RouterOutlet} from "@angular/router";
import {AuthService} from "./services/AuthService";
import {from} from "rxjs";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{
  title = 'nepflowFrontend';
  newNepenthesRoute: string = "nepenthes/add";
  growlistRoute: string = "nepenthes/growlist"

  profileRoute: string = "user/overview";
  isLoggedIn:boolean = false;


  constructor(public authService: AuthService) {
  }

  async ngOnInit(): Promise<void> {
    this.isLoggedIn = await this.authService.isAuthenticated();
  }



}
