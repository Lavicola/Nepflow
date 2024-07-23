import {Component, OnInit} from '@angular/core';
import {UsermanagementService} from "../../user-management/services/usermanagement.service";
import {UserPrivacyDto} from "../../user-management/models/user-privacy-dto";
import {BehaviorSubject, combineLatest, combineLatestWith, debounceTime, Observable, startWith} from "rxjs";
import {map} from "rxjs/operators";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-all-users-overview',
  templateUrl: './all-users-overview.component.html',
  styleUrl: './all-users-overview.component.css'
})
export class AllUsersOverviewComponent implements OnInit {

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
