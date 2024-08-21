import {Component, Input, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {FormControl} from "@angular/forms";
import {Observable} from "rxjs";
import {CloneDto} from "../models/clone-dto";
import {GrowlistmanagementService} from "../services/growlistmanagement.service";
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-nepenthes-clone-table',
  templateUrl: './nepenthes-clone-table.component.html',
  styleUrl: './nepenthes-clone-table.component.css'
})
export class NepenthesCloneTableComponent implements OnInit{

  displayedColumns: string[] = ['cloneId', 'sex',"nickname","producer",'Location'];
  @Input() existingClones: Observable<CloneDto[]> = new Observable<CloneDto[]>();

  dataSource:MatTableDataSource<CloneDto> = new MatTableDataSource<CloneDto>();

  cloneIdFilter = new FormControl();
  producerFilter = new FormControl();
  nicknameFilter = new FormControl();
  sexFilter = new FormControl();
  filteredValues = {
    cloneId: '', producer: '', nickname: '',
    sex: ''
  };

  columnDefinitions = [
    { def: "cloneId", label: "cloneId", visible: true },
    { def: "producer", label: "producer", visible: true },
    { def: "sex", label: "sex", visible: true },

    { def: "nickname", label: "nickname", visible: true },
    { def: "Location", label: "Location", visible: true },
    { def: "action", label: "action", visible: true },


  ];


  constructor(private growlistService:GrowlistmanagementService,
              private _snackBar: MatSnackBar) {


  }


  getDisplayedColumns(): string[] {
    return this.columnDefinitions.filter(cd => cd.visible).map(cd => cd.def);
  }


  ngOnInit() {
    this.existingClones.subscribe(clones => {
      this.dataSource.data = clones
    });

    this.cloneIdFilter.valueChanges.subscribe((cloneIdFilterValue:string) => {
      this.filteredValues['cloneId'] = cloneIdFilterValue;
      this.dataSource.filter = JSON.stringify(this.filteredValues);
    });

    this.producerFilter.valueChanges.subscribe((nameFilterValue:string) => {
      this.filteredValues['producer'] = nameFilterValue;
      this.dataSource.filter = JSON.stringify(this.filteredValues);
    });

    this.nicknameFilter.valueChanges.subscribe((nicknameFilterValue:string) => {
      this.filteredValues['nickname'] = nicknameFilterValue;
      this.dataSource.filter = JSON.stringify(this.filteredValues);
    });
    this.sexFilter.valueChanges.subscribe((sexFilterValue:string) => {
      this.filteredValues['sex'] = sexFilterValue;
      this.dataSource.filter = JSON.stringify(this.filteredValues);
    });

    this.dataSource.filterPredicate = this.customFilterPredicate();

  }

  customFilterPredicate() {
    const myFilterPredicate = (data: CloneDto, filter: string): boolean => {
      let searchString = JSON.parse(filter);


      return this.isTrue(data.producer,searchString.producer) &&
        this.isTrue(data.cloneId,searchString.cloneId) &&
        this.isTrue(data.sex,searchString.sex) &&
        this.isTrue(data.nickname,searchString.nickname)

    }
    return myFilterPredicate;
  }

  isTrue(text:string|undefined,search_string:string){
    console.log("called")
    console.log(text + search_string)
    if(text == undefined){
      return true
    }else{
      return text.toString().trim().toLowerCase().startsWith(search_string.toLowerCase())
    }

  }

  onActionClick(element:CloneDto) {


    if(element.internalCloneId){
      this.growlistService.growlistCloneAddInternalCloneIdPost({internalCloneId:element.internalCloneId}).subscribe({
        next: () => this._snackBar.open("added Plant to Growlist!","Ok",{
          duration: 1500,
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          panelClass: ['snackbar-success']

        }),
        error: ()=>   this._snackBar.open("Failed to add Plant to Growlist, please try again later","Ok",{
          duration: 1500,
          horizontalPosition: 'center',
          verticalPosition: 'bottom',
          panelClass: ['snackbar-error']
        })
      })
    }
  }
}
