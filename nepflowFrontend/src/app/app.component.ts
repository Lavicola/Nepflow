import {Component, OnInit} from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {AuthService} from "./core/services/auth.service";
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";
import {MatToolbar} from "@angular/material/toolbar";
import {MatAnchor, MatButton} from "@angular/material/button";
import {NgIf} from "@angular/common";
import {DarkLightThemeComponent} from "./core/components/dark-light-theme/dark-light-theme.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, MatMenuTrigger, MatToolbar, MatMenu, MatMenuItem, MatAnchor, NgIf, MatButton, DarkLightThemeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.sass'
})
export class AppComponent  implements OnInit{
  title = 'nepflowFrontend';
  username!:string;

  newNepenthesRoute: string = "nepenthes/add";
  publicGrowlistsRoute: string = "users/growlist";
  myGrowlistRoute: string = "growlist/"
  myTradeRoute:string = "trades/"
  myOpenTradeRoute:string = "trades/open/"

  profileRoute: string = "user/overview";
  isLoggedIn:boolean = false;
  pollenOffersRoute: string = "pollenoffers"


  constructor(public authService: AuthService,
  ) {

  }

  async ngOnInit(): Promise<void> {
    this.isLoggedIn = await this.authService.isAuthenticated();

  }



}
