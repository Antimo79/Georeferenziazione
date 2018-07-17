/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { GeoreferenziazioneTestModule } from '../../../test.module';
import { BbbaGeo01MySuffixDeleteDialogComponent } from 'app/entities/bbba-geo-01-my-suffix/bbba-geo-01-my-suffix-delete-dialog.component';
import { BbbaGeo01MySuffixService } from 'app/entities/bbba-geo-01-my-suffix/bbba-geo-01-my-suffix.service';

describe('Component Tests', () => {
    describe('BbbaGeo01MySuffix Management Delete Component', () => {
        let comp: BbbaGeo01MySuffixDeleteDialogComponent;
        let fixture: ComponentFixture<BbbaGeo01MySuffixDeleteDialogComponent>;
        let service: BbbaGeo01MySuffixService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GeoreferenziazioneTestModule],
                declarations: [BbbaGeo01MySuffixDeleteDialogComponent]
            })
                .overrideTemplate(BbbaGeo01MySuffixDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BbbaGeo01MySuffixDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BbbaGeo01MySuffixService);
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
