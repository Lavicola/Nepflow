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
  newCloneRoute: string = "nepenthes/clone/add";
  userAddCloneToProfile: string = "user/nepenthes/add";
  profileRoute: string = "user/overview";
  myPlantsRoute: string = "user/profile/nepenthes";
  nepenthesAdd: string = "user/nepenthes/add";
  hybridAdd: string = "hybrid/add";
  isLoggedIn:boolean = false;


  constructor(public authService: AuthService) {
  }

  async ngOnInit(): Promise<void> {
    this.isLoggedIn = await this.authService.isAuthenticated();
  }



}
