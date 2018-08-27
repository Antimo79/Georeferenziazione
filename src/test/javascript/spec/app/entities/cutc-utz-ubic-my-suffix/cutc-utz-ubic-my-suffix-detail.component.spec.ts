/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { CutcUtzUbicMySuffixDetailComponent } from 'app/entities/cutc-utz-ubic-my-suffix/cutc-utz-ubic-my-suffix-detail.component';
import { CutcUtzUbicMySuffix } from 'app/shared/model/cutc-utz-ubic-my-suffix.model';

describe('Component Tests', () => {
    describe('CutcUtzUbicMySuffix Management Detail Component', () => {
        let comp: CutcUtzUbicMySuffixDetailComponent;
        let fixture: ComponentFixture<CutcUtzUbicMySuffixDetailComponent>;
        const route = ({ data: of({ cutcUtzUbic: new CutcUtzUbicMySuffix(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [CutcUtzUbicMySuffixDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(CutcUtzUbicMySuffixDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(CutcUtzUbicMySuffixDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.cutcUtzUbic).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
