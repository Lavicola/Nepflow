import {Component, Input, OnInit} from '@angular/core';
import {GrowlistmanagementService} from "../services/growlistmanagement.service";
import {GrowlistDto} from "../models/growlist-dto";
import {BehaviorSubject} from "rxjs";
import {SpecimenCloneDto} from "../models/specimen-clone-dto";
import {ImageManagementService} from "../../core/Image/services/image-management.service";
import {ActivatedRoute} from "@angular/router";
import {UsernameService} from "../../../services/UsernameService";

@Component({
  selector: 'app-user-growlist',
  templateUrl: './user-growlist.component.html',
  styleUrl: './user-growlist.component.css'
})
export class UserGrowlistComponent implements OnInit {

  growlistSubject = new BehaviorSubject<GrowlistDto>({});
  growlist = this.growlistSubject.asObservable();
  @Input() specimens: SpecimenCloneDto[] = [];
  username!: string | undefined;

  constructor(private growmanagementService: GrowlistmanagementService,
              private imageService: ImageManagementService,
              private usernameService: UsernameService,
              private route: ActivatedRoute
  ) {

    this.growlist.subscribe({
      next: (growlist: GrowlistDto) => {
        if (growlist.specimens) {
          this.specimens = growlist.specimens
        }
      }
    })


  }

  ngOnInit(): void {
    this.usernameService.getUsernameObs().subscribe({
      next: (username: string) => this.getGrowlist(username),
    })

    this.route.paramMap.subscribe(params => {
      if (params.get('user') != null) {
        // @ts-ignore
        this.getGrowlist(params.get('user'))
      }
    });

  }

  getGrowlist(username: string) {
    this.growmanagementService.growlistUsernameClonesGet({username: username}).subscribe({
      next: (growlist) => this.growlistSubject.next(growlist),
      error: () => console.log("error")
    })

  }


}
