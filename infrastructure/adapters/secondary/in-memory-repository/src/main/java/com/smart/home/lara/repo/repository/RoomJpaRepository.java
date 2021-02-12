package com.smart.home.lara.repo.repository;

import com.smart.home.lara.repo.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/** lara Created by Catalin on 2/12/2021 */
public interface RoomJpaRepository extends JpaRepository<RoomEntity, UUID> {}
