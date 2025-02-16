package com.sprint.mission.discodeit.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.UUID;

@Getter
@RequiredArgsConstructor // final로 선언됐거나 null이 아닌 필드에 대해서만 생성자로 생성
public class Channel implements Serializable {
  private static final long serialVersionUID = 1L;

// @RequiredArgsConstructor가 final 필드를 생성자의 매개변수로 포함하도록 강제하는데,
// id와 createdAt은 명시적으로 초기화되지 않아서 NullPointerException이 발생할 가능성이 높음.
  // => 여기서 UUID.randomUUID()와 System.currentTimeMillis()로 초기화해주는 것이 일반적인 패턴
  private final UUID id = UUID.randomUUID();
  private final Long createdAt = System.currentTimeMillis();
  private Long updatedAt = null;

  @NonNull // name, topic을 final로 선언하면 update메서드로 값 바꿔주는 걸 못하니까 @NonNull 어노테이션을 쓴다. +import lombok.NonNull
  private String name;

  @NonNull
  private String topic;

  public void update(String name, String topic) {
    this.name = name;
    this.topic = topic;
    this.updatedAt = System.currentTimeMillis();
  }

  @Override
  public String toString() {
    return "Channel{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", topic='" + topic + '\'' +
        '}';
  }
}