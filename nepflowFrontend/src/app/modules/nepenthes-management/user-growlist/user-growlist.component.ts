import { Component } from '@angular/core';
import {GrowlistmanagementService} from "../services/growlistmanagement.service";

@Component({
  selector: 'app-user-growlist',
  templateUrl: './user-growlist.component.html',
  styleUrl: './user-growlist.component.css'
})
export class UserGrowlistComponent {

  constructor(private growmanagementService:GrowlistmanagementService) {
  }



}
