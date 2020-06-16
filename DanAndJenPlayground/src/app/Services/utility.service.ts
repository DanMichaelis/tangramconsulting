import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UtilityService {

  constructor() { }

  public static getRandom(max: number, min?: number): number {
    if (!min) {
      let min = 0;
    }
    return Math.random() * (max - min) + min;
  }

  public static getRandomInt(max: number, min?: number): number {
    if (!min) {
      let min = 0;
    }
    return Math.floor(Math.random() * (max + 1 - min)) + min;
  }
}
