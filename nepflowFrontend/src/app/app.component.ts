import { Component } from '@angular/core';
import {CommonModule} from "@angular/common";
import {RouterModule, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'nepflowFrontend';
  newNepenthesRoute: string = "nepenthes/add";
  newCloneRoute: string = "nepenthes/clone/add";
  userAddCloneToProfile: string = "user/nepenthes/add";
  profileRoute: string = "user/profile";
  myPlantsRoute: string = "user/profile/nepenthes";
  nepenthesAdd: string = "user/nepenthes/add";

}