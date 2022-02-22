import { Component } from '@angular/core';
import { IJuice } from './interfaces/juice';
import { JuiceService } from './juice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lab1f';
  juicesList: IJuice[] = [];
  isUpdateFormOpened: boolean = false;
  updatedJuice?: IJuice;

  constructor(private service: JuiceService) { }

  ngOnInit(): void {
    this.updateJuices();
    this.service.list.subscribe(
      (list: IJuice[]) => {
        this.juicesList = list;
      }
    )
  }

  setJuicesList = (list: IJuice[]): void => {
    this.juicesList = list;
  }

  chooseUpdatedJuice(juice: IJuice) {
    if (juice.id !== undefined) {
      this.updatedJuice = juice;
      this.isUpdateFormOpened = true;
    } else {
      this.isUpdateFormOpened = false;
    }
  }

  closePopup() {
    this.updatedJuice = undefined;
    this.isUpdateFormOpened = false;
  }

  updateJuices() {
    this.service.getJuices().subscribe(
      (juices) => {
        console.log('juices', juices);
        this.service.setList(juices);
      }
    );
  }

  addJuice(juice: IJuice) {
    this.service.postJuice(juice).subscribe(
      () => {
        this.updateJuices();
      }
    )
  }

  deleteJuice(juice: IJuice) {
    this.service.deleteJuice(juice).subscribe(
      () => {
        this.updateJuices();
      }
    )
  }
}
