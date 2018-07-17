/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbbaGeo01MySuffixComponent } from 'app/entities/bbba-geo-01-my-suffix/bbba-geo-01-my-suffix.component';
import { BbbaGeo01MySuffixService } from 'app/entities/bbba-geo-01-my-suffix/bbba-geo-01-my-suffix.service';
import { BbbaGeo01MySuffix } from 'app/shared/model/bbba-geo-01-my-suffix.model';

describe('Component Tests', () => {
    describe('BbbaGeo01MySuffix Management Component', () => {
        let comp: BbbaGeo01MySuffixComponent;
        let fixture: ComponentFixture<BbbaGeo01MySuffixComponent>;
        let service: BbbaGeo01MySuffixService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbbaGeo01MySuffixComponent],
                providers: []
            })
                .overrideTemplate(BbbaGeo01MySuffixComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BbbaGeo01MySuffixComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbbaGeo01MySuffixService);
        });

        it('Should call load all on init', () => {
            // GIVEN
            const headers = new HttpHeaders().append('link', 'link;link');
            spyOn(service, 'query').and.returnValue(
                of(
                    new HttpResponse({
                        body: [new BbbaGeo01MySuffix(123)],
                        headers
                    })
                )
            );

            // WHEN
            comp.ngOnInit();

            // THEN
            expect(service.query).toHaveBeenCalled();
            expect(comp.bbbaGeo01S[0]).toEqual(jasmine.objectContaining({ id: 123 }));
        });
    });
});
