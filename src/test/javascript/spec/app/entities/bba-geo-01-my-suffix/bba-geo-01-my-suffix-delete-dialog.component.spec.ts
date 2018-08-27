/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbaGeo01MySuffixDeleteDialogComponent } from 'app/entities/bba-geo-01-my-suffix/bba-geo-01-my-suffix-delete-dialog.component';
import { BbaGeo01MySuffixService } from 'app/entities/bba-geo-01-my-suffix/bba-geo-01-my-suffix.service';

describe('Component Tests', () => {
    describe('BbaGeo01MySuffix Management Delete Component', () => {
        let comp: BbaGeo01MySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<BbaGeo01MySuffixDeleteDialogComponent>;
        let service: BbaGeo01MySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbaGeo01MySuffixDeleteDialogComponent]
            })
                .overrideTemplate(BbaGeo01MySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BbaGeo01MySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbaGeo01MySuffixService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
