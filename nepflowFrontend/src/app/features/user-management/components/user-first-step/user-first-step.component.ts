import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {UserDto} from "../../../../core/models/user-dto";
import {UsermanagementService} from "../../services/usermanagement.service";
import {AuthService} from "../../../../core/services/auth.service";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatOption, MatSelect} from "@angular/material/select";
import {MatInputModule} from "@angular/material/input";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-user-first-step',
  standalone: true,
  imports: [
    MatFormField,
    MatInputModule,
    MatSelect,
    MatOption,
    ReactiveFormsModule,
    MatLabel,
    MatOption,
    NgForOf
  ],
  templateUrl: './user-first-step.component.html',
  styleUrl: './user-first-step.component.sass'
})
export class UserFirstStepComponent implements OnInit {

  user: UserDto = {};
  userService!: UsermanagementService;
  public authService!: AuthService;
  userForm: FormGroup


  constructor(useService: UsermanagementService,
              authService: AuthService,
  ) {
    this.authService = authService;
    this.userService = useService;
    this.userForm = new FormGroup({
      username: new FormControl(""),
      contactInformation: new FormControl(""),
      country: new FormControl(),

    });


  }

  public createUserPostRequest(user: UserDto) {
    this.userService.userPost({body: user}).subscribe({
      next: (user: UserDto) => {
        this.user = user
      },
      error: (error: string) => console.log("No Post" + error)
    })


  }

  public createUserPutRequest(user: UserDto) {
    this.userService.userPut({body: user}).subscribe({
      next: (user: UserDto) => this.user = user,
      error: (error: string) => {
        console.log("No Post" + error);
      }
    })


  }

  ngOnInit(): void {
    this.userService.userGet().subscribe({
      next: (user: UserDto) => {
        console.log(user)
        this.user = user
        this.userForm.patchValue({
          username: this.user.username,
          contactInformation: this.user.contactInformation,
          country: this.user.country,
        })
      },
      error: () => console.log("User does not exist (yet)")
    });
  }


  login() {
    this.authService.login()
  }

  onSubmit(userForm: FormGroup) {
    let userDto: UserDto = {};
    Object.assign(userDto, userForm.value);
    // TODO maybe a better solution one day
    if (this.user.username) {
      console.log("put")
      this.createUserPutRequest(userDto);
    } else {
      console.log("post")
      this.createUserPostRequest(userDto);
    }

  }

  onUpdate() {
    let u: UserDto = {};
    u.country = this.userForm.controls["region"].value;
    u.username = this.userForm.controls["username"].value;
    u.contactInformation = this.userForm.controls["contactInformation"].value;

    this.userService.userPut({body: u}).subscribe({
      next: () => console.log("nice"),
      error: () => console.log("error")
    });

  }

  protected readonly countries = supported_countries;
}

// Instead of additional API for Countries, store supported Countries in global Variable
var supported_countries = ['USA', 'Europe', 'Asia'];

