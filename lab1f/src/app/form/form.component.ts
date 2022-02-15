import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { JuiceService } from '../juice.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  juiceForm = new FormGroup({
    title: new FormControl(''),
    descr: new FormControl(''),
    img: new FormControl(''),
  });

  constructor(private service: JuiceService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.setJuice(this.juiceForm.value);
  }

}
