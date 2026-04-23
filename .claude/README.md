# Claude Code Configuration

This directory contains Claude Code agents, skills, and configuration.

## Directory Structure

```
.claude/
├── org-agents/           # Org-managed agents (read-only submodule)
│   └── .claude/agents/   # Central agent definitions
│       ├── pr-merge-orchestrator.agent.md
│       ├── pr-reviewer.agent.md
│       ├── pr-risk-assessor.agent.md
│       ├── pr-fixer.agent.md
│       ├── pr-approver.agent.md
│       └── pr-merger.agent.md
├── org-skills/           # Org-managed skills (read-only submodule)
│   └── .claude/skills/   # Central skill definitions
│       └── pr-merge.skill.md
├── agents/               # Local agent overrides (team-writable)
├── skills/               # Local skill overrides (team-writable)
├── settings.json         # Configuration (loads both org and local)
└── README.md             # This file
```

## Org-Managed vs Local

### Org-Managed (Read-Only Submodules)

- **Location**: `.claude/org-agents/` and `.claude/org-skills/`
- **Source**: `my-platform-org/agentic-development-framework` (control repo)
- **Ownership**: Platform team
- **Purpose**: Shared agents/skills used across all repositories
- **Modification**: Submit PRs to control repo, not here
- **Updates**: See "Updating Org Agents" below

### Local Overrides (Team-Writable)

- **Location**: `.claude/agents/` and `.claude/skills/`
- **Ownership**: Your team
- **Purpose**: Service-specific customizations or overrides
- **Modification**: Commit directly to this repo
- **Shadowing**: Local agents override org agents by name

## Updating Org Agents

To get the latest org-managed agents and skills:

```bash
# Update to latest from control repo
git submodule update --remote .claude/org-agents
git submodule update --remote .claude/org-skills

# Commit the updates
git add .claude/org-agents .claude/org-skills
git commit -m "chore: update org-managed agents and skills"
git push
```

To pin to a specific version:

```bash
# Check current version
cd .claude/org-agents
git log --oneline -5

# Pin to specific commit
cd ../..
git submodule update --init
cd .claude/org-agents
git checkout <commit-sha>
cd ../..
git add .claude/org-agents
git commit -m "chore: pin org-agents to <commit-sha>"
```

## Overriding Org Agents

If you need to customize an org agent for this service:

1. **Copy** the agent from `.claude/org-agents/.claude/agents/` to `.claude/agents/`
2. **Modify** the local copy
3. **Commit** to this repo

The local copy will shadow the org agent by name.

**When to override:**
- Service-specific risk thresholds (e.g., stricter for payment-service)
- Custom auto-fix patterns for this codebase
- Team-specific review criteria

**When NOT to override:**
- General improvements (contribute back to org)
- Bug fixes (fix in org, don't override)
- Shared patterns (keep org agents consistent)

## Agent Usage

**PR Merge Workflow:**
```bash
# Dry run (preview)
/pr-merge --dry-run

# Manual mode (confirm each action)
/pr-merge --manual

# Auto mode (fully automated)
/pr-merge
```

See `.claude/org-skills/.claude/skills/pr-merge.skill.md` for full documentation.

## Configuration

**Risk Thresholds:**
- Org-level defaults: `my-platform-org/agentic-development-framework/config/pr-merge-policies.yaml`
- Team overrides: `my-platform-org/agentic-development-framework/templates/team-configs/<team>/.claude/agents/pr-merge-config.yaml`
- Repo overrides: `.claude/agents/pr-merge-config.yaml` (if needed)

**Override Hierarchy:**
1. Org defaults (lowest priority)
2. Team config (medium priority)
3. Repo config (highest priority)

## Troubleshooting

**Agents not loading:**
```bash
# Check settings.json paths
cat .claude/settings.json

# Verify submodules initialized
git submodule status

# Re-initialize if needed
git submodule update --init --recursive
```

**Submodule conflicts:**
```bash
# Reset submodules to tracked commit
git submodule update --force
```

**Want to contribute improvements:**
1. Fork `my-platform-org/agentic-development-framework`
2. Make changes to agents/skills
3. Submit PR to control repo
4. Once merged, update submodules here

## Questions?

- **Platform team**: Questions about org agents, skills, policies
- **Your team lead**: Questions about local overrides, service-specific config
- **Control repo**: `my-platform-org/agentic-development-framework`

---

**Last Updated**: 2026-04-22
**Architecture**: Git submodules with local override capability
