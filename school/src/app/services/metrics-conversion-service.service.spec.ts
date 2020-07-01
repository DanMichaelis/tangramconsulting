import { TestBed } from '@angular/core/testing';

import { MetricsConversionServiceService } from './metrics-conversion-service.service';

describe('MetricsConversionServiceService', () => {
  let service: MetricsConversionServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MetricsConversionServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
