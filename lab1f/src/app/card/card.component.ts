import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  @Input() id: number = 0;
  @Input() title: string = "";
  @Input() descr: string = "";
  @Input() img: string = "";
  @Output() chooseUpdatedJuice = new EventEmitter();
  @Output() deleteJuice = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  handleEditClick() {
    this.chooseUpdatedJuice.emit({ id: this.id, title: this.title, descr: this.descr, img: this.img });
  }

  handleDelete() {
    this.deleteJuice.emit({ id: this.id, title: this.title, descr: this.descr, img: this.img });
  }

}
