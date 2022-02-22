import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { IJuice } from '../interfaces/juice';
import { JuiceService } from '../juice.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {
  @Input() juice?: IJuice;
  @Output() closePopup = new EventEmitter();
  @Output() updated = new EventEmitter();

  constructor(private service: JuiceService) { }

  ngOnInit(): void {
  }

  close() {
    this.closePopup.emit();
  }

  updateJuice() {
    if (this.juice) {
      this.service.putJuice(this.juice).subscribe(
        () => {
          this.updated.emit();
          this.closePopup.emit();
        }
      );
    }
  }

}
