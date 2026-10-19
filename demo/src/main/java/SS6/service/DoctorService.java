package SS6.service;

import SS6.exception.DoctorNotFoundException;
import SS6.model.dto.request.DoctorRequestDto;
import SS6.model.dto.response.DoctorResponseDTo;
import SS6.model.entity.Doctor;
import SS6.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }

    public Doctor addDoctor(DoctorRequestDto doctorRequestDto){
       Doctor doctor = new Doctor();
       doctor.setDoctorCode(doctorRequestDto.getDoctorCode());
       doctor.setFullName(doctorRequestDto.getFullName());
       doctor.setSpecialization(doctorRequestDto.getSpecialization());
       doctor.setExperienceYears(doctorRequestDto.getExperienceYears());
       return doctorRepository.save(doctor);

    }

    public void deleteDoctor(Long id ){
        Doctor doctor= doctorRepository.findById(id).orElseThrow(()->
                new DoctorNotFoundException("Khong tim thay bac si co ID :" + id));
        doctorRepository.delete(doctor);

    }

    public DoctorResponseDTo upDateDoctor(Long id,DoctorRequestDto doctorRequestDto ){
        Doctor doctor = doctorRepository.findById(id).orElseThrow(()->
                new DoctorNotFoundException("Khong tim thay bac si co ID : "+ id));

        doctor.setDoctorCode(doctorRequestDto.getDoctorCode());
        doctor.setFullName(doctorRequestDto.getFullName());
        doctor.setSpecialization(doctorRequestDto.getSpecialization());
        doctor.setExperienceYears(doctorRequestDto.getExperienceYears());

        Doctor responDoctor = doctorRepository.save(doctor);

        return new DoctorResponseDTo(
                responDoctor.getDoctorCode(),
                responDoctor.getFullName(),
                responDoctor.getSpecialization(),
                responDoctor.getExperienceYears());

    }

    public List<DoctorResponseDTo> getAllDoctor(){
     List<Doctor> doctors =   doctorRepository.findAll();
     return doctors.stream().map(doctor -> new DoctorResponseDTo(
             doctor.getDoctorCode(),
             doctor.getFullName(),
             doctor.getSpecialization(),
             doctor.getExperienceYears()
     )).toList();
    }
}
