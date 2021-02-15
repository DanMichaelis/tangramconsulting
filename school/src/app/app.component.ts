import { Component } from '@angular/core';
import { MenuComponent } from './components/navigation/menu/menu.component';
import {NavbarComponent} from './components/navigation/navbar/navbar.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'school';
}
