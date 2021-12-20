package com.project.third_project.service;

import com.project.third_project.dto.ReservationRequest;
import com.project.third_project.entity.abailableTime.AvailableTime;
import com.project.third_project.entity.abailableTime.AvailableTimeRepository;
import com.project.third_project.entity.availableDate.AvailableDate;
import com.project.third_project.entity.availableDate.AvailableDateRepository;
import com.project.third_project.entity.hospital.HospitalRepository;
import com.project.third_project.entity.reservation.Reservation;
import com.project.third_project.entity.reservation.ReservationRepository;
import com.project.third_project.entity.users.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UsersRepository usersRepository;
    private final HospitalRepository hospitalRepository;
    private final AvailableDateRepository availableDateRepository;
    private final AvailableTimeRepository availableTimeRepository;


    @Transactional
    public Long save(ReservationRequest reservationRequest){
        Reservation reservation = Reservation.builder()
                .users(usersRepository.getById(reservationRequest.getUsersId()))
                .hospital(hospitalRepository.getById(reservationRequest.getHospitalId()))
                .availableDate(availableDateRepository.getById(reservationRequest.getAvailableDateId()))
                .availableTime(availableTimeRepository.getById(reservationRequest.getAvailableTimeId()))
                .build();
        AvailableDate availableDate = availableDateRepository.findById(reservationRequest.getAvailableDateId()).orElseThrow();
        availableDate.minus1(availableDate.getQuantity()); // Date에 갯수 수량 마이너스

        AvailableTime availableTime = availableTimeRepository.findById(reservationRequest.getAvailableTimeId()).orElseThrow();
        availableTime.minus1(availableTime.getQuantity()); // time 갯수 수량 마이너스

        return reservationRepository.save(reservation).getId();
    }

}
