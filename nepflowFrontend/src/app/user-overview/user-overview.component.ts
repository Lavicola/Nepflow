import {Component, OnInit} from '@angular/core';
import {UserDto} from "../models/user-dto";
import {UserService} from "../services/user.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {AuthService} from "../services/auth.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";


@Component({
  selector: 'app-user-overview',
  templateUrl: './user-overview.component.html',
  styleUrls: ['./user-overview.component.css']
})
export class UserOverviewComponent implements OnInit{

  user:UserDto = {};
  userService!: UserService;
  public authService!:AuthService;
  userForm: FormGroup


  constructor(useService:UserService,
              authService:AuthService,
  ) {
    this.authService = authService;
    this.userService = useService;
    this.userForm = new FormGroup({
      username: new FormControl(this.user.username),
      contactInformation: new FormControl(this.user.contactInformation),
      region: new FormControl(this.user.region),

    });


  }

  public createUserRequest(user:UserDto){

    this.userService.userPost({body: user}).subscribe({
      next: (user) => this.user = user,
      error: () => console.log("NO Post")
    })


  }




  ngOnInit(): void {
    this.userService.userGet().subscribe({
      next: (user) => this.user = user,
      error: () => console.log("NO")
    })
    if(this.user.username == null){
      this.createUserRequest({});
    }

    return

  }


  login() {
    this.authService.login()
  }

  onSubmit(userForm: FormGroup) {

  }
}
