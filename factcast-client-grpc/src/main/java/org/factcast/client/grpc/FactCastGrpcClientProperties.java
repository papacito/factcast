/*
 * Copyright © 2017-2020 factcast.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.factcast.client.grpc;

import java.time.Duration;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "factcast.grpc.client")
@Data
@Accessors(fluent = false)
public class FactCastGrpcClientProperties {

  private int catchupBatchsize = 50;

  private boolean enableFastForward = true;

  private String id = null;

  @NestedConfigurationProperty
  private ResilienceConfiguration resilience = new ResilienceConfiguration();

  @Data
  @Accessors(fluent = false)
  public static class ResilienceConfiguration {
    private boolean enabled = true;

    private Duration window = Duration.ofSeconds(30);

    private int retries = 10;

    private Duration interval = Duration.ofMillis(100);
  }
}
