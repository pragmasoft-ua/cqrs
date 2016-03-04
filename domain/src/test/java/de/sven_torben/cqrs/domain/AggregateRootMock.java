package de.sven_torben.cqrs.domain;

import java.util.UUID;

public class AggregateRootMock extends AggregateRoot {

  public boolean ahasBeenCalled;
  public boolean bhasBeenCalled;

  public AggregateRootMock() {
    super();
  }

  public AggregateRootMock(final UUID id, int version) {
    super(id, version);
    ahasBeenCalled = false;
    bhasBeenCalled = false;
  }

  @Override
  protected void handle(IAmAnEvent event) {
    throw new RuntimeException();
  }

  protected void handle(EventMockA event) {
    ahasBeenCalled = true;
  }

  protected void handle(EventMockB event) {
    bhasBeenCalled = true;
  }

  public void doA() {
    apply(new EventMockA());
  }

  public void doB() {
    apply(new EventMockB());
  }
}