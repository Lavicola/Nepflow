import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {UserDto} from "../../../../core/models/user-dto";
import {UsermanagementService} from "../../services/usermanagement.service";
import {AuthService} from "../../../../core/services/auth.service";
import {MatFormField, MatFormFieldModule, MatLabel} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {NgForOf} from "@angular/common";
import {MatButton, MatIconButton} from "@angular/material/button";
import {FileUploadComponent} from "../../../../core/components/file-upload/file-upload.component";
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {MatIcon} from "@angular/material/icon";
import {MatOption, MatSelect} from "@angular/material/select";

@Component({
  selector: 'app-user-first-step',
  standalone: true,
  imports: [
    MatLabel,
    MatFormField,
    MatRadioGroup,
    MatCardTitle,
    MatCard,
    MatCardContent,
    MatRadioButton,
    MatButton,
    MatFormFieldModule,
    MatInputModule,
    MatIcon,
    MatIconButton,
    NgForOf,
    ReactiveFormsModule,
    FileUploadComponent,
    MatSelect,
    MatOption,

  ],
  templateUrl: './user-first-step.component.html',
  styleUrl: './user-first-step.component.sass'
})
export class UserFirstStepComponent implements OnInit {

  user: UserDto = {};
  userService!: UsermanagementService;
  public authService!: AuthService;
  userForm: FormGroup
  protected readonly countries = supported_countries;


  constructor(useService: UsermanagementService,
              authService: AuthService,
              private formBuilder:FormBuilder
  ) {
    this.authService = authService;
    this.userService = useService;
    this.userForm = this.formBuilder.group({
      username:['',[Validators.required]], //TODO async validator for username
      contactInformation:['',Validators.required],
      country:["IN"]
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

  onSubmit() {
    let userDto: UserDto = {};
    Object.assign(userDto, this.userForm.value);
    // TODO maybe a better solution one day
    if (this.user.username) {
      this.createUserPutRequest(userDto);
    } else {
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

  submit() {
    let userDto: UserDto = {};
    console.log(this.userForm.value)
    Object.assign(userDto, this.userForm.value);
    // TODO maybe a better solution one day
    if (this.user.username) {
      this.createUserPutRequest(userDto);
    } else {
      this.createUserPostRequest(userDto);
    }

  }
}

// Instead of additional API for Countries, store supported Countries in global Variable
var supported_countries = ['USA', 'Europe', 'Asia'];

