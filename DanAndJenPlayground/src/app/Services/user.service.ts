import { Injectable } from '@angular/core';
import { DashboardUser } from '../data objects/dashboarduser';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  public static getCurrentUser(): DashboardUser {
    return (new DashboardUser('dmichael', 'Dan', 'Michaelis', 'dan.michaelis@perficient.com'));
  }
}
