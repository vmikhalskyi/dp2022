import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Juice } from '../interfaces/juice';
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
  @Input() setJuicesList!: (args: Juice[]) => void;

  constructor(private service: JuiceService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.setJuice(this.juiceForm.value).subscribe((juices) => {
      this.setJuicesList(juices as Juice[]);
    });
  }

}
