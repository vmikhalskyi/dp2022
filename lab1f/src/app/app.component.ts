import { Component } from '@angular/core';
import { Juice } from './interfaces/juice';
import { JuiceService } from './juice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'lab1f';
  juicesList: Juice[] = [];

  constructor(private service: JuiceService) { }

  ngOnInit(): void {
    this.service.getJuices().subscribe(
      (juices) => {
        this.juicesList = juices;
      }
    )
  }

  setJuicesList = (list: Juice[]): void => {
    this.juicesList = list;
  }
}
