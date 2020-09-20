# Intro
taintbenchmark用于评估污点分析扫描器引擎的能力。

白盒扫描器的普遍使用污点分析技术，那么有两方面影响这扫描器的准确性：扫描器引擎本身（如是否支持准确的过程间分析）和规则完备性（如source、sink配置是否充分），
在相同benchmark上使用不同规则比较不同扫描器是无意义的。

## 过程内分析
* intraprocedural：基本过程内分析能力，如出现误报漏报说明扫描器没有污点分析能力
* flowsensitive：流敏感，出现误报或漏报说明扫描器不支持流敏感

## 过程间分析
* interprocedural：基本过程间分析能力
* contextsensitive: 上下文敏感
* fieldsensitive：域敏感


# Source & Sink
本benchmark只会出现以下sink点：
## Source
* javax.servlet.ServletRequest#getParameter
## Sink
* java.io.PrintWriter#println(java.lang.String)
* org.apache.commons.exec.launcher.CommandLauncher#exec(org.apache.commons.exec.CommandLine, java.util.Map<java.lang.String,java.lang.String>, java.io.File)
* java.lang.Runtime#exec(java.lang.String)
