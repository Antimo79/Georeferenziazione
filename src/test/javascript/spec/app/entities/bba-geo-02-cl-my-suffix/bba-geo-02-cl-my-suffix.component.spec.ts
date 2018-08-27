/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbaGeo02ClMySuffixComponent } from 'app/entities/bba-geo-02-cl-my-suffix/bba-geo-02-cl-my-suffix.component';
import { BbaGeo02ClMySuffixService } from 'app/entities/bba-geo-02-cl-my-suffix/bba-geo-02-cl-my-suffix.service';
import { BbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';

describe('Component Tests', () => {
    describe('BbaGeo02ClMySuffix Management Component', () => {
        let comp: BbaGeo02ClMySuffixComponent;
        let fixture: ComponentFixture<BbaGeo02ClMySuffixComponent>;
        let service: BbaGeo02ClMySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbaGeo02ClMySuffixComponent],
                providers: []
            })
                .overrideTemplate(BbaGeo02ClMySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BbaGeo02ClMySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbaGeo02ClMySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BbaGeo02ClMySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.bbaGeo02Cls[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
