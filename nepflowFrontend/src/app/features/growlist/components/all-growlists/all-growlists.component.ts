import {Component, OnInit} from '@angular/core';
import { BehaviorSubject, combineLatestWith, map, Observable, startWith} from "rxjs";
import {UsermanagementService} from "../../../user-management/services/usermanagement.service";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {UserPrivacyDto} from "../../../../core/models/user-privacy-dto";
import {RouterLink} from "@angular/router";
import {AsyncPipe, NgForOf} from "@angular/common";
import {MatFormField} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";

@Component({
  selector: 'app-all-growlists',
  standalone: true,
  imports: [
    RouterLink,
    NgForOf,
    ReactiveFormsModule,
    MatFormField,
    AsyncPipe,
    MatInputModule
  ],
  templateUrl: './all-growlists.component.html',
  styleUrl: './all-growlists.component.sass'
})
export class AllGrowlistsComponent implements OnInit {

  private usersSubject = new BehaviorSubject<UserPrivacyDto[]>([]);
  protected usersObs = this.usersSubject.asObservable();
  protected usernameFilter = new FormControl("");
  filteredUsers$!: Observable<UserPrivacyDto[]>;



  constructor(private userService: UsermanagementService) {



  }


  ngOnInit(): void {
    this.userService.usersGet().subscribe({
      next: (userList) => this.usersSubject.next(userList),
      error: () => console.log("error")
    })
    this.filteredUsers$ = this.usersObs.pipe(
      combineLatestWith(this.usernameFilter.valueChanges.pipe(startWith(''))),
      map(([users, filterString]) => {
        if (!filterString) {
          return users;
        }
        return users.filter(user =>
          // @ts-ignore
          user.username?.toLowerCase().includes(filterString.toLowerCase())
        );
      })
    );



  }

}

