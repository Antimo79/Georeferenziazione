/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbaGeo02ClMySuffixDetailComponent } from 'app/entities/bba-geo-02-cl-my-suffix/bba-geo-02-cl-my-suffix-detail.component';
import { BbaGeo02ClMySuffix } from 'app/shared/model/bba-geo-02-cl-my-suffix.model';

describe('Component Tests', () => {
    describe('BbaGeo02ClMySuffix Management Detail Component', () => {
        let comp: BbaGeo02ClMySuffixDetailComponent;
        let fixture: ComponentFixture<BbaGeo02ClMySuffixDetailComponent>;
        const route = ({ data: of({ bbaGeo02Cl: new BbaGeo02ClMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbaGeo02ClMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BbaGeo02ClMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BbaGeo02ClMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.bbaGeo02Cl).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
