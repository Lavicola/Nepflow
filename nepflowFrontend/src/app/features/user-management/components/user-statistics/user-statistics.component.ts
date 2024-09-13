import {Component, OnInit} from '@angular/core';
import {AsyncPipe, NgForOf} from "@angular/common";
import {MatButtonToggle, MatButtonToggleGroup} from "@angular/material/button-toggle";
import {MatLabel} from "@angular/material/form-field";
import {BehaviorSubject, catchError, combineLatest, map, Observable, of} from "rxjs";
import {TradeDto} from "../../../pollenexchange/models/trade-dto";
import {TradeService} from "../../../pollenexchange/services/trade.service";
import {AuthService} from "../../../../core/services/auth.service";
import {UserDto} from "../../../../core/models/user-dto";
import {TradeStatisticsComponent} from "../../../pollenexchange/components/trade-statistics/trade-statistics.component";

@Component({
  selector: 'app-user-statistics',
  standalone: true,
  imports: [
    AsyncPipe,
    MatButtonToggle,
    MatButtonToggleGroup,
    MatLabel,
    NgForOf,
    TradeStatisticsComponent
  ],
  templateUrl: './user-statistics.component.html',
  styleUrl: './user-statistics.component.sass'
})
export class UserStatisticsComponent implements OnInit {



  constructor(private userService: AuthService) {


  }

  ngOnInit(): void {
    this.userService.getUser().subscribe({
      next: (user: UserDto) => {
        console.log('User fetched:', user);
      },
      error: (error) => {
        console.error('Error occurred while fetching the user:', error);
      },
      complete: () => {
        console.log('User fetching completed.');
      }
    });


  }

}
