package com.devonfw.tools.ide.url.model.file.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devonfw.tools.ide.context.IdeContext;
import com.devonfw.tools.ide.url.model.AbstractUrlModelTest;
import com.devonfw.tools.ide.url.model.folder.AbstractUrlToolOrEdition;
import com.devonfw.tools.ide.version.VersionIdentifier;
import com.devonfw.tools.ide.version.VersionRange;

/**
 * Test of {@link ToolSecurity} and {@link AbstractUrlToolOrEdition#getSecurityFile()}.
 */
public class ToolSecurityTest extends AbstractUrlModelTest {

  @Test
  public void testSecurity() {

    // arrange
    IdeContext context = newContext();

    // act
    Collection<CVE> security = context.getDefaultToolRepository()
        .findSecurity("tomcat", "tomcat", VersionIdentifier.of("2.40.1"));
    List<VersionRange> versionRanges = new ArrayList<>();
    // assert
    assertThat(security).containsExactly(new CVE("java", 2.0f, versionRanges));
  }
}
