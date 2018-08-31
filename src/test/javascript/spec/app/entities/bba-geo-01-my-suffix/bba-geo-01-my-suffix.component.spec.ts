/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbaGeo01MySuffixComponent } from 'app/entities/bba-geo-01-my-suffix/bba-geo-01-my-suffix.component';
import { BbaGeo01MySuffixService } from 'app/entities/bba-geo-01-my-suffix/bba-geo-01-my-suffix.service';
import { BbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';

describe('Component Tests', () => {
    describe('BbaGeo01MySuffix Management Component', () => {
        let comp: BbaGeo01MySuffixComponent;
        let fixture: ComponentFixture<BbaGeo01MySuffixComponent>;
        let service: BbaGeo01MySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbaGeo01MySuffixComponent],
                providers: []
            })
                .overrideTemplate(BbaGeo01MySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BbaGeo01MySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbaGeo01MySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BbaGeo01MySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.bbaGeo01S[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
