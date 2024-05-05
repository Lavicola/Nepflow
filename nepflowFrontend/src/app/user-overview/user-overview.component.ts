import {Component, OnInit} from '@angular/core';
import {UserDto} from "../models/user-dto";
import {UsermanagementService} from "../services/usermanagement.service";
import {AuthService} from "../services/auth.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";


@Component({
  selector: 'app-user-overview',
  templateUrl: './user-overview.component.html',
  styleUrls: ['./user-overview.component.css']
})
export class UserOverviewComponent implements OnInit {

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
      country: new FormControl(["a", "b"]),

    });


  }

  public createUserRequest(user: UserDto) {
    this.userService.userPost({body: user}).subscribe({
      next: (user: UserDto) => {
        this.user = user
      },
      error: (error) => console.log("No Post" + error)
    })


  }


  ngOnInit(): void {
    this.userService.userGet().subscribe({
      next: (user: UserDto) => {
        this.user = user
        this.userForm.patchValue({
          username:this.user.username,
          contactInformation: this.user.contactInformation,
        })
      },
      error: () => console.log("User does not exist (yet)")
    });
    return
  }


  login() {
    this.authService.login()
  }

  onSubmit(userForm: FormGroup) {
    console.log(combinedList)
    console.log(userForm.value)
    Object.assign(this.user, userForm.value);
    this.createUserRequest(this.user);

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

  protected readonly combinedList = combinedList;
}

// Instead of additional API for Countries, store supported Countries in global Variable
var supported_countries = ['Belgium', 'Bulgaria', 'Denmark', 'Germany', 'Estonia', 'Finland', 'France', 'Greece', 'Ireland', 'Italy', 'Croatia', 'Latvia', 'Lithuania', 'Luxembourg', 'Malta', 'Netherlands', 'Austria', 'Poland', 'Portugal', 'Romania', 'Sweden', 'Slovakia', 'Slovenia', 'Spain', 'Czech Republic', 'Hungary', 'Cyprus', 'USA'];
var supported_countries_code = ['BE', 'BG', 'DK', 'DE', 'EE', 'FI', 'FR', 'GR', 'IE', 'IT', 'HR', 'LV', 'LT', 'LU', 'MT', 'NL', 'AT', 'PL', 'PT', 'RO', 'SE', 'SK', 'SI', 'ES', 'CZ', 'HU', 'CY', 'EU', 'BE', 'BG', 'DK', 'DE', 'EE', 'FI', 'FR', 'GR', 'IE', 'IT', 'HR', 'LV', 'LT', 'LU', 'MT', 'NL', 'AT', 'PL', 'PT', 'RO', 'SE', 'SK', 'SI', 'ES', 'CZ', 'HU', 'CY'];
var combinedList = supported_countries.map((country, index) => {
  return {name: country, code: supported_countries_code[index]};
});
