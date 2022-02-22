import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { IJuice } from '../interfaces/juice';
import { JuiceService } from '../juice.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  juiceForm = new FormGroup({
    id: new FormControl(-1),
    title: new FormControl(''),
    descr: new FormControl(''),
    img: new FormControl(''),
  });
  @Input() setJuicesList!: (args: IJuice[]) => void;
  @Output() addJuice = new EventEmitter();

  constructor(private service: JuiceService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.addJuice.emit(this.juiceForm.value);
    this.juiceForm.setValue({ id: -1, title: '', descr: '', img: '' });
  }

}
