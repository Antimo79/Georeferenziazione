/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbaGeo01MySuffixDetailComponent } from 'app/entities/bba-geo-01-my-suffix/bba-geo-01-my-suffix-detail.component';
import { BbaGeo01MySuffix } from 'app/shared/model/bba-geo-01-my-suffix.model';

describe('Component Tests', () => {
    describe('BbaGeo01MySuffix Management Detail Component', () => {
        let comp: BbaGeo01MySuffixDetailComponent;
        let fixture: ComponentFixture<BbaGeo01MySuffixDetailComponent>;
        const route = ({ data: of({ bbaGeo01: new BbaGeo01MySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbaGeo01MySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BbaGeo01MySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BbaGeo01MySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.bbaGeo01).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
