import {Component, OnInit} from '@angular/core';
import {AuthService} from "./services/AuthService";
import {UsernameService} from "./services/UsernameService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit{
  title = 'nepflowFrontend';
  username!:string;

  newNepenthesRoute: string = "nepenthes/add";
  publicGrowlistsRoute: string = "users/growlist";
  myGrowlistRoute: string = "growlist/"

  profileRoute: string = "user/overview";
  isLoggedIn:boolean = false;


  constructor(public authService: AuthService,
              ) {

  }

  async ngOnInit(): Promise<void> {
    this.isLoggedIn = await this.authService.isAuthenticated();

  }



}
