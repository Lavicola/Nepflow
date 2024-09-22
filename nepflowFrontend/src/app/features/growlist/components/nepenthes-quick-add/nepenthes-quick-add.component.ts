import {Component, Input} from '@angular/core';
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {CdkTextareaAutosize} from "@angular/cdk/text-field";
import {MatButton} from "@angular/material/button";
import {Observable} from "rxjs";
import {CloneDto} from "../../models/clone-dto";
import {
  MatCell,
  MatCellDef, MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef, MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef,
  MatTable,
  MatTableDataSource
} from "@angular/material/table";
import {GrowlistmanagementService} from "../../services/growlistmanagement.service";
import {NepenthesService} from "../../services/nepenthes.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {FormsModule} from "@angular/forms";
import {MatOption, MatSelect} from "@angular/material/select";
import _default from "chart.js/dist/plugins/plugin.tooltip";
import duration = _default.defaults.animation.duration;
import {NgStyle} from "@angular/common";

@Component({
  selector: 'app-nepenthes-quick-add',
  standalone: true,
  imports: [
    MatFormField,
    MatInput,
    MatLabel,
    CdkTextareaAutosize,
    MatButton,
    MatTable,
    MatHeaderCellDef,
    MatCellDef,
    MatHeaderCell,
    MatCell,
    MatColumnDef,
    FormsModule,
    MatHeaderRowDef,
    MatRowDef,
    MatRow,
    MatHeaderRow,
    MatSelect,
    MatOption,
    NgStyle
  ],
  templateUrl: './nepenthes-quick-add.component.html',
  styleUrl: './nepenthes-quick-add.component.sass'
})
export class NepenthesQuickAddComponent {
  @Input() existingClones: Observable<CloneDto[]> = new Observable<CloneDto[]>();
  dataSource: MatTableDataSource<CloneDto> = new MatTableDataSource<CloneDto>();
  cloneList: string = "";
  displayedColumns: string[] = ['nepentheName', 'cloneId', 'producer'];

  //TODO remove all success from the text area while leaving the red ones

  constructor(private growlistService: GrowlistmanagementService,
              private nepenthesService: NepenthesService,
              private _snackBar: MatSnackBar) {
  }


  formatTextArea(textArea: string): string[] {
    let cleanedTextArea = "";
    cleanedTextArea = textArea.toUpperCase().split("\n",).join(",").toUpperCase()
    return cleanedTextArea.split(",").filter(word => word != "")
  }

  loadClones() {
    let cloneIds: string[] = this.formatTextArea(this.cloneList)
    let uniqueIdsWithCount = cloneIds.reduce((acc: Record<string, number>, str: string) => {
      acc[str] = (acc[str] || 0) + 1;
      return acc;
    }, {});
    if (!Object.keys(uniqueIdsWithCount).length) {
      this._snackBar.open("Could not find any Clones, please insert them before", "Close", {
        duration: 5000
      })
      return
    }
    this.growlistService.growlistAddClonesPost({body: cloneIds}).subscribe({
      next: (response) => {
        let clones: CloneDto[] = []
        let success = response.success;
        let failures = response.failure;
        success?.forEach(clone => clones.push(clone));
        failures?.forEach(cloneId => clones.push({
          cloneId: cloneId,
          producer: "",
          nepenthesName: ""
        }))
        this.cloneList = failures != undefined ? failures?.join(",") : ""
        this.dataSource.data = clones

      }
    })


  }


}

